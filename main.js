/**
 * @param {string} str1 
 * @param {string} str2 
 * @returns {string}
 */
function getLongestSubString(str1, str2) {
    let dpValue = 0;
    let maxLen = 0;
    let resultRow = 0;
    let resultColumn = 0;
    let row = 0;
    let column = str1.length - 1;
    let count = str1.length + str2.length - 1;
    while (count > 0) {
        let startRow = row;
        let startColumn = column;
        while (column < str1.length && row < str2.length) {
            if (str1[column] === str2[row]) {
                dpValue += 1;
            } else {
                dpValue = 0;
            }
            if (dpValue > maxLen) {
                maxLen = dpValue;
                resultRow = row;
                resultColumn = column;
            }
            column++;
            row++;
        }
        if (column > 0) {
            column = startColumn - 1;
            row = 0;
        } else {
            column = 0;
            row = startRow + 1;
        }
        count--;
    }
    return str1.substring(resultColumn-maxLen+1,resultColumn+1);
}

const str1 = '1AB2345CD';
const str2 = '12345EF';
console.log(getLongestSubString(str1, str2));