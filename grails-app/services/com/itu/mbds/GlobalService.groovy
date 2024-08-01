package com.itu.mbds

import grails.gorm.transactions.Transactional
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired

@Transactional
class GlobalService {
    def getStartOfDay() {
        def calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    def getEndOfDay() {
        def calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        calendar.set(Calendar.MILLISECOND, 999)
        return calendar.time
    }
    def docToMap(Document doc) {
        def map = [:]
        doc.keySet().each { key ->
            map[key] = doc.get(key)
        }
        return map
    }

}

