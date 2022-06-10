function solution(array, s) {
    return array.filter(v => s.startsWith(v)).length
}

