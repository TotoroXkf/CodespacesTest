const getLongestSubString = require('./main');

test('case1', () => {
    const str1 = '1AB2345CD';
    const str2 = '12345EF';
    expect(getLongestSubString(str1,str2)).toBe("2345");
});