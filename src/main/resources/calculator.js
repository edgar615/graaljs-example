var calculator = new Object();
// var FileClass = Java.type('java.io.File');

calculator.add = function (n1, n2) {return n1 + n2};
calculator.subtract = function (n1, n2) {return n1 - n2};
calculator.multiply = function (n1, n2) {return n1 * n2};
calculator.divide = function (n1, n2) {return n1 / n2};

// calculator.testFile = function() {
//
//     var file = new FileClass("D:/workspace/graaljs-example/src/main/resources/calculator.js");
//     return file;
// }