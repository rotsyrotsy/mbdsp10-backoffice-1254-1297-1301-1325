package com.itu.mbds

import grails.mongodb.MongoEntity
import org.bson.types.ObjectId

import java.text.ParseException
import java.text.SimpleDateFormat

class Transaction implements MongoEntity<Transaction> {
    static mapWith = "mongodb"
    ObjectId id
    int exchange_id
    int owner_id
    int taker_id
    String creation_date
    String updated_date
    String status

    static constraints = {
        id nullable: false
        exchange_id nullable: false
        owner_id nullable: false
        taker_id nullable: false
        creation_date nullable: false
        updated_date nullable: false
        status nullable: false
    }
    static mapping = {
        id attr: '_id'
        version false
    }
    private Date parseDate(String dateStr) {
        try {
            def format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") // Adjust the format as needed
            def dd = format.parse(dateStr)
            return dd
        } catch (ParseException e) {
            return null
        }
    }
    private String formatDate(Date date) {
        def format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") // Adjust the format as needed
        return format.format(date)
    }
    Exchange getExchange(){
        return Exchange.get(this.exchange_id)
    }
    User getOwner(){
        return User.get(this.owner_id)
    }
    User getTaker(){
        return User.get(this.taker_id)
    }
    Date getCreationDateM() {
        return parseDate(creation_date)
    }
    Date getMUpdatedDate() {
        return updated_date ? parseDate(updated_date) : null
    }

}