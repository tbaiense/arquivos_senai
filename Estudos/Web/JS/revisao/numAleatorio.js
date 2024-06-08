"use strict";
// Gera um número entre o intervalo definido (1-99)
function rand (min = 0, max= 100) {
    max = Math.floor(max);
    min = Math.ceil(min);
    return Math.floor(Math.random() * (max-min) + min);
}

let array = Array(100)
for (let i=0; i<array.length; i++) {
    array[i] = rand(0.2, array.length*10);
}
let menor=array[0];
array.forEach((elem) => {
    if (menor > elem) 
        menor = elem;
});
console.log(menor);