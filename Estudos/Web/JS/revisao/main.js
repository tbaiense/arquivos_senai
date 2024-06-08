"use strict";

let array = [1, 2, 3, 4];

array.forEach(function doubles(elem) {
    array.push(elem);
});

console.log(array);

