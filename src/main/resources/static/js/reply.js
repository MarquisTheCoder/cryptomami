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
     
});