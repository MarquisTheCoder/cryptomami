"use strict";

/*
 Creator: Deshawn Marquis, Williams,
 GitHub Profile: https://github.com/MarquisTheCoder,
 Date Created: 12/4/22,
 Time Created: 5:56 PM,
 File Name: posts.js,
 File Description:
 */


(function () {
     
     //deleting the post from the forum webpage
     //and from the server with a get requests
     //for speed in development. A GET requests
     //isnt the right answer to delete from the server
     //but its a quick work around for CSRF protection
     //that springboot provides
    $(".destroy-my-post").click(function(){
         let currentPost = $(this).parents(".post")
         let postId = currentPost.attr("data-id")
         
         if(confirm("Are you sure you want to delete this post?")){
              fetch(`/post/delete/${postId}`)
                    .then(response => response.json())
                    .then(json => console.log(json))
     
              currentPost.remove();
         }else{
              console.log("post not deleted")
         }
         console.log(postId)
     })
     
     $(".edit-my-post").click(function(){
          let currentPost = $(this).parents(".post")
          let currentPostId =  currentPost.attr("data-id")
          
          let currentPostContent = currentPost.children(".content").text()
          console.log(currentPostId)
          let editSection = $(".edit-body")
          editSection.children(".content-box").val(currentPostContent)
          editSection.children(".content-box").attr("data-post-id", currentPostId)
          if(editSection.hasClass("hide")){
               editSection.removeClass("hide")
          }
     })
     
     $(".content-box").on("input", function(){
          let contentBoxCurrentPost = $(this).attr("data-post-id")
     
          $(`*[data-id="${contentBoxCurrentPost}"]`).children(".content")
          .text($(this).val())
     })
     
     $(".edit-send").click(function(){
          let contentBox = $(this).siblings()[0]
          let contentBoxValue = $(contentBox).val()
          let contentBoxCurrentPost = $(contentBox).attr("data-post-id")
          
          fetch(`/post/edit/${contentBoxCurrentPost}/${contentBoxValue}`)
               .then(response => console.log(response))
          
          $(this).parents(".edit-body").addClass("hide")
              
          
     })
})();