function solution(arr) {
    let answer = arr[0]

    for (let i = 1; i < arr.length; i++) {
        if (Math.abs(answer) > Math.abs(arr[i])) {
            answer = arr[i];
        } else if (Math.abs(answer) === Math.abs(arr[i])) {
            answer = Math.min(answer, arr[i])
        }
    }

    return answer
}

console.log(solution([-5, 2, -1, 3]))