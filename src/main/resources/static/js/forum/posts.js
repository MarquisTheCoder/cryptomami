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
})();