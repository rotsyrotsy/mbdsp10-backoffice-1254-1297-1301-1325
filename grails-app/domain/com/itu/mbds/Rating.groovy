package com.itu.mbds

import grails.mongodb.MongoEntity
import org.bson.types.ObjectId

import java.text.ParseException
import java.text.SimpleDateFormat

class Rating implements MongoEntity<Rating> {
    static mapWith = "mongodb"
    ObjectId id
    int user_id
    int concerned_id
    String creation_date
    String review
    Double stars

    static constraints = {
        id nullable: false
        user_id nullable: false
        concerned_id nullable: false
        creation_date nullable: false
        review nullable: true
        stars nullable: false
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
    User getUser(){
        return User.get(this.user_id)
    }
    User getConcernedUser(){
        return User.get(this.concerned_id)
    }
    String getFormattedCreationDate() {
        return formatDate(creation_date)
    }
    Date getCreationDate() {
        return creation_date? parseDate(creation_date): null
    }
}