function solution(arr) {
    return Array.from(new Set(arr.join(" ").split(" "))).sort()
}

console.log(solution(["We can", "give advice", "but we cannot give conduct"]))