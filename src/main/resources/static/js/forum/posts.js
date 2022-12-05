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
         currentPost.remove();
         let postId = currentPost.attr("data-id")
         fetch(`/post/delete/${postId}`, { method: 'DELETE' })
     })
})();