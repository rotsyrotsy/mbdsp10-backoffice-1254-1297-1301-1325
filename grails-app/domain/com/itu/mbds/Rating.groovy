package com.itu.mbds

import grails.mongodb.MongoEntity
import org.bson.types.ObjectId

import java.text.ParseException
import java.text.SimpleDateFormat

class Rating implements MongoEntity<Rating> {
    static mapWith = "mongodb"
    ObjectId id
    int userId
    int concerned_id
    String review
    Double stars

    static constraints = {
        id nullable: false
        userId nullable: false
        concerned_id nullable: false
        review nullable: true
        stars nullable: false
    }
    static mapping = {
        table '`Ratings`'
        id attr: '_id'
        version false
        userId column: '`userId`'
        concerned_id column: '`concerned_user_id`'
        review column: '`review`'
        stars column: '`rating`'
    }
    User getUser(){
        return User.get(this.userId)
    }
    User getConcernedUser(){
        return User.get(this.concerned_id)
    }
}