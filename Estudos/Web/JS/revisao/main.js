"use strict";
const TAM = 10;
var arrayExt = new Array(TAM);
function rand(max=10) {
    max = Math.floor(max)+1;
    return Math.floor(Math.random() * max);
}

function fill(array=0, max=10) {
    for(let i=0; i<array.length; i++) {
        array[i] = rand(max);
    }
    return arrayExt;
}
