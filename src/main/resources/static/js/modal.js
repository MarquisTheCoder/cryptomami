"use strict";

/*
 Creator: Deshawn Marquis, Williams,
 GitHub Profile: https://github.com/MarquisTheCoder,
 Date Created: 11/22/22,
 Time Created: 12:59 PM,
 File Name: modal.js,
 File Description:
 */


(function () {
     alert('testing import')
     $('#login-button').on('click', ()=>{
          alert('clicked')
        $('.login-controller').toggleClass('gone');
     });
})();