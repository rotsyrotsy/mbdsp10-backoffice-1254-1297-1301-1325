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
    Date creation_date
    Date updated_date
    String status
    Double latitude
    Double longitude

    static constraints = {
        id nullable: false
        exchange_id nullable: false
        owner_id nullable: false
        taker_id nullable: false
        creation_date nullable: false
        updated_date nullable: false
        status nullable: false
        latitude nullable: true
        longitude nullable: true
    }
    static mapping = {
        id attr: '_id'
        version false
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
    Date getCreationDate() {
        return creation_date
    }
    Date getUpdatedDate() {
        return updated_date
    }

}