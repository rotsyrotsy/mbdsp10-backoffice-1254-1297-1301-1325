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
            return format.parse(dateStr)
        } catch (ParseException e) {
            return null
        }
    }

    private String formatDate(String date) {
        def inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        inputFormatter.setTimeZone(TimeZone.getTimeZone("UTC"))
        def parsedDate = inputFormatter.parse(date)
        def outputFormatter = new SimpleDateFormat("MMM dd yyyy")
        def formattedDate = outputFormatter.format(parsedDate)
        return formattedDate
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
    String getFormattedCreationDate() {
        return formatDate(creation_date)
    }
    Date getCreationDate() {
        return creation_date? parseDate(creation_date): null
    }
    Date getUpdatedDate() {
        return updated_date ? parseDate(updated_date) : null
    }

}