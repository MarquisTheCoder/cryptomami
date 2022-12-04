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
     globalForumStateManager.active("posts")
     
     //iterating through all selected page option and altering global state based on click
     function createEventListenersForPage(pageList){
          pageList.forEach(name => {
               let className = `.${name}-button`
               
               $(className).click(function() {
                    
                    globalForumStateManager.active(name)
                    pageList.forEach(navName => {
                         let nonClicked = `.${navName}-button`
                         if(this.className != nonClicked ){
                              $(nonClicked).children(".nav-img").removeClass("selected")
                         }
                    })
                    $(this).children(".nav-img").addClass("selected")
               })
          })
     }
     createEventListenersForPage(["home", "settings","threads","posts","stats"])
    
})();