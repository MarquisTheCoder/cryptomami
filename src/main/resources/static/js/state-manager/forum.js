"use strict";

//trying to create a react like state manager
//which doesnt need to make external calls to the local api
//but keeps the state of each "page" object and switches
//them between 'active' and 'inactive' states
//'
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
