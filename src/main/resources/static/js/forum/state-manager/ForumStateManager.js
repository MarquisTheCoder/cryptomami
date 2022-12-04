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
     active(pageName){
          this.listOfDomObjects.forEach(object => {
               //selecting the object by class/page name
               // //when found it activates this page and deactivates
               // //all other pages in the object list.
               if($(object).hasClass(pageName)){
                    $(object).removeClass("inactive")
               }else{
                    $(object).addClass("inactive")
               }
          })
     }
}

const globalForumStateManager = new ForumStateManager([
                                                     $(".home"),
                                                     $(".settings"),
                                                     $(".threads"),
                                                     $(".posts"),
                                                     $(".stats")
                                                ]
);

