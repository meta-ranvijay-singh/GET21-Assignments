//Method to change direction of fontawsome arrow icon
let changeArrow = function(btn){
    
    let link = document.querySelector("."+btn);
    let arrowElement = link.querySelector(".arrow");
    let arrow = arrowElement.getElementsByTagName("i");
    arrow.item(0).classList.toggle("fa-chevron-down");
}