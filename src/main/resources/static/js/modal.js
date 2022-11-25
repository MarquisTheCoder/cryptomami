"use strict";

/*
 Creator: Deshawn Marquis, Williams,
 GitHub Profile: https://github.com/MarquisTheCoder,
 Date Created: 11/22/22,
 Time Created: 12:59 PM,
 File Name: modal.js,
 File Description:
 */

window.onload = () =>{
     
     let loginControllers = document.querySelectorAll(".login-controller")
     let loginButton = document.querySelector('#login-button')
     let modalBackgroundBlurred = document.querySelector('.login-modal-background')
     function toggleModal(){
          loginControllers.forEach(x => {
               x.classList.toggle("gone");
          })
     }
     loginButton.addEventListener("click", ()=> {
          toggleModal();
     });
     
     modalBackgroundBlurred.addEventListener("click", ()=>{
          toggleModal();
     })
}