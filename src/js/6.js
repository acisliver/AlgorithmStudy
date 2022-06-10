function solution(arr) {
    return new Set(arr.join(" ").split(" ")).size
}

console.log(solution(["no pain", "no", "gain"]))