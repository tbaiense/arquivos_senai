"use strict";
//Recebe uma array ou objeto para somar os valores reais contidos nas propriedades ou índices
function somarValores(itens) {
  let soma = 0;
  const valores = Object.values({...itens}).forEach((e) => {
    if (typeof e == 'number' && !Number.isNaN(e)) { 
      e = Number.parseFloat(e);
      soma+= e;
    }
  });
  return soma;
}

const array = [1, 2, 3];
const obj = {thiago: 10, marcio: 32, renan: 25, douglas: 50, data: '10/3/2024'}
console.log(somarValores(obj));