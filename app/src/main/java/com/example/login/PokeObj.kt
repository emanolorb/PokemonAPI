package com.example.login

class PokeObj(name:String, number:Int, imageMale:String, imageFemale:String, imageShinyMale:String, imageShinyFemale:String) {
    var name:String = ""
    var number:Int = 0
    var imageMale:String = ""
    var imageFemale:String = ""
    var imageShinyMale:String = ""
    var imageShinyFemale:String = ""

    init{
        this.name = name
        this.number = number
        this.imageMale = imageMale
        this.imageFemale = imageFemale
        this.imageShinyMale = imageShinyMale
        this.imageShinyFemale = imageShinyFemale
    }
}