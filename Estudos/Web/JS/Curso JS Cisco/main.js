"use strict";

let arr1= [1, 2, 3, 4, 5];
arr1= arr1.concat([6, 7, 8, 9, 10]);
arr1[1000] = 100;
for (const elemento of arr1) {
    elemento ? console.log(elemento) : null;
}