const { PI, square } = require('./math'); // a bit like import, the file pulled from must have explicit instructions to expose those values with module.exports.pi = pi; for instance

const cats = require('./shelter')
// console.log(PI)

// console.log(square(9))
console.log("REQUIRED AN ENTIRE DIRECTORY!", cats)
