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
     let replyButtons = $(".reply-button")
     $(replyButtons).click(function(){
          let currentForm = $(this)
               .parents(".post")
               .children(".reply-forum")
               .toggleClass("hide")
     })
     
     let repliesButton = $(".replies-button")
     
     $(repliesButton).click(function(){
          let currentPost =  $(this).parents(".post")
          let repliesSection = $(this)
               .parents(".post-container")
               .children(".replies")
          let postId = $(currentPost).attr("data-post-id")
          if($(repliesSection).text() == ""){
               fetch(`/forum/${postId}/post`)
          .then((response) => response.json())
          .then((data) =>{
               data.forEach(hash =>
                    $(repliesSection).append(`
                    <div class="reply">
                        <h4>${hash.title}</h4>
                        <hr>
                        <p>${hash.content}</p>
                    </div>`)
               )
          });
          }else{
               $(repliesSection).html("")
          }
          
     
     });
});