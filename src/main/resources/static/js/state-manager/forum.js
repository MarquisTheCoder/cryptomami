"use strict";


class ForumStateManager{
     
     constructor(listOfDomObjects) {
          this.listOfDomObjects = listOfDomObjects
     }
     active(selectedDomObject){
          
          
          if($(selectedDomObject).hasClass("inactive")){
               $(selectedDomObject).toggleClass("inactive")
          }
          this.listOfDomObjects.forEach(object => {
               
               if( $(object) != $(selectedDomObject)){
                    $(object).toggleClass("inactive")
               }
          })
     }
}
