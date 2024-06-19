# metodos Array.prototype
## retornam número
- Array.prototype.indexOf(elemento)

## retornam array
- Array.prototype.slice(startIndex, endIndex) >> retorna o pedaço da array delimitada pelo primeiro parâmetro e o último (exclusive)
- Array.prototype.splice(startIndex, qntToDelete, replaceWith) >> altera uma parte da array delimitada pelos dois primeiros parâmetros e retorna os elementos que foram alterados
- Array.prototype.toSpliced(startIndex, qntToDelete, replaceWith)
- Array.prototype.filter(callback) >> retorna uma nova array cos elementos da array original que fazem a callback retornar true
- Array.prototype.map(callback) >> retorna array modificada pela callback

## retornam string
- Array.prototype.join(','); >> concatena os elementos da array e retorna numa nova string
