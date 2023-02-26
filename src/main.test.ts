import { describe, expect, test } from '@jest/globals';
import { getConvertWays } from './mian';

describe('test', () => {
    test('case1', () => {
        expect(getConvertWays('1111')).toBe(5);
    });
});