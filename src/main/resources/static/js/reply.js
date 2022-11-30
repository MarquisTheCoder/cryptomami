"use strict";

/*
 Creator: Deshawn Marquis, Williams,
 GitHub Profile: https://github.com/MarquisTheCoder,
 Date Created: 11/28/22,
 Time Created: 9:42 AM,
 File Name: reply.js,
 File Description:
 */

$(function(){
     //grabbing the reply button to be used
     //to display the reply form and post it to the database
     //with the id of the current post as the parent id
     let replyButtons = $(".reply-button")
     $(replyButtons).click(function(){
          let currentForm = $(this)
               .parents(".post")
               .children(".reply-forum")
               .toggleClass("hide")
     })
     
     let repliesButton = $(".replies-button")
     
     $(repliesButton).click(function(){
          //grabs the current post we are trying to show replies for
          let currentPost =  $(this).parents(".post")
          
          //grabs the replies section in which replies are displayed
          let repliesSection = $(this)
               .parents(".post-container")
               .children(".replies")
          
          //uses the post id generated by the server and accessed through
          //the templating engine to be used for the post request to the server
          let postId = $(currentPost).attr("data-post-id")
          if($(repliesSection).text() == ""){
               //sends the post request via fetch api
               fetch(`/forum/${postId}/post`)
                    .then((response) => response.json())
                    .then((data) =>{
                         data.forEach(hash =>{
                              $(repliesSection).append(`
                              <div class="reply">
                                  <h4>${hash.title}</h4><hr>
                                  <p>${hash.content}</p>
                              </div>`)
                         })
                    });
          }else{
               $(repliesSection).html("");
          }
     });
});