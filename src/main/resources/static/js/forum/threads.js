"use strict";

/*
 Creator: Deshawn Marquis, Williams,
 GitHub Profile: https://github.com/MarquisTheCoder,
 Date Created: 12/4/22,
 Time Created: 10:59 PM,
 File Name: threads.js,
 File Description:
 */

let globalCurrentThreadId = 0;
(function () {
     
     $(".add-post-button").click(function(){
          let threadId = $(this).parents(".thread").attr("data-thread-id")
          globalCurrentThreadId = threadId
          let threadsPost = $(".thread-posts")
          $(threadsPost).html("")
          fetch(`/threads/${threadId}`, {method: "GET"})
               .then(response => response.json())
               .then(json => {
                    console.log(json)
                    json.forEach(post => {
                         let postHtml = $(`
                            <div class="thread-post">
                            
                                <div class="user-info">
                                       <img src="${post.profileImg}" alt="">
                                     <h4 class="posts-username">${post.username}</h4>
                                </div>
                                
                                <div class="thread-posts-content">
                                   ${post.content}
                                </div>
                            </div>
                         `)
                         $(threadsPost).append(postHtml)
                    })
               })
     })
     
    $("#send-post").click(function (){
         let threadsPost = $(".thread-posts")
          console.log(globalCurrentThreadId)
          
         let postHtml = $(`
                            <div class="thread-post">
                            
                                <div class="user-info">
                                     <img src="${$(this).attr("data-profileImg")}" alt="">
                                     <h4 class="posts-username">${$(this).attr("data-username")}</h4>
                                     
                                </div>
                                
                                <div class="thread-posts-content">
                                   ${$("#post-content").val()}
                                </div>
                            </div>
                         `)
         threadsPost.append(postHtml);
         
         
         fetch(`/post/create/${$(this).attr("data-user-id")}/${globalCurrentThreadId}/${$("#post-content").val()}`)
               .then(response => console.log(response.status))
         $("#post-content").val("")
     })
     
     $(".threads-header img").click(function(){
          $(".make-thread-background").toggleClass("hide")
     })
     
     $(".make-thread .make-thread-button").click(function(){
          fetch(`/threads/create/${$(".make-thread input").val()}`)
               .then(response => console.log(response.status))
     })
     
     $(".make-thread button").click(function(){
          $(this).parents(".make-thread-background").toggleClass("hide")
     })
})();