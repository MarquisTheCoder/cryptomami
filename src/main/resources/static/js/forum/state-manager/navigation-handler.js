"use strict";

/*
 Creator: Deshawn Marquis, Williams,
 GitHub Profile: https://github.com/MarquisTheCoder,
 Date Created: 12/4/22,
 Time Created: 9:39 AM,
 File Name: navigation-handler.js,
 File Description:
 */


(function () {
     //making sure the starting page is the homepage
     globalForumStateManager.active("home")
     
     //iterating through all selected page option and altering global state based on click
     function createEventListenersForPage(pageList){
          pageList.forEach(name => {
               $(`.${name}-button`).click(() => {
                    globalForumStateManager.active(name)
               })
          })
     }
     createEventListenersForPage(["home", "settings","threads","posts","stats"])
    
})();