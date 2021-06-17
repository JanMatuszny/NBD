db.people.insert({ 
    "sex" : "Male", 
    "first_name" : "Tomasz", 
    "last_name" : "Dziewa", 
    "job" : "Programmer", 
    "email" : "s11509@pjwstk.edu.pl", 
    "location" : {
        "city" : "Warsaw", 
        "address" : {
            "streetname" : "Aleje Jerozolimskie", 
            "streetnumber" : "132-136"
        }
    }, 
    "description" : "Zima idzie", 
    "height" : "186.0", 
    "weight" : "100.0", 
    "birth_date" : "1990-02-11T07:22:24Z", 
    "nationality" : "Poland", 
    "credit" : [
        {
            "type" : "mastercard", 
            "number" : "56022578962043117", 
            "currency" : "EUR", 
            "balance" : "1000000.63"
        }, 
        {
            "type" : "jcb", 
            "number" : "5602220902466171", 
            "currency" : "PLN", 
            "balance" : "0.01"
        }
    ]
})