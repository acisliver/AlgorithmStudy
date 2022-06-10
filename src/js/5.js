function solution(arr1, arr2) {
    return arr1.filter(v => arr2.includes(v)).sort((v1, v2) => v1 - v2)
}

console.log(solution([1, 7, 8, 4], [2, 4, 6, 8]))