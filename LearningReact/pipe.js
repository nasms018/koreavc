/**
 * 
 * @param  {...any} functions 
 * @returns 
 */

const pipe = (...functions) => dataToConvert => functions.reduce((acc, fn) => fn(acc), dataToConvert);
























