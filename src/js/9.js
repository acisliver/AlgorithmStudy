function solution(s) {
    return s.length === 6 ? s.split("")
        .map(v => v.charCodeAt(0) < 71 && v.charCodeAt(0) > 47)
        .reduce((v1, v2) => v1 && v2) : false
}

console.log(solution("DACC32"))