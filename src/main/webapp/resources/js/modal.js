document.getElementById("openModalBtn").addEventListener("click", function() {
    document.getElementById("myModal").style.display = "block";
});

document.getElementsByClassName("close")[0].addEventListener("click", function() {
    document.getElementById("myModal").style.display = "none";
});

document.getElementById("savePlanBtn").addEventListener("click", function() {
    // 여기에 여행 계획을 저장하는 로직을 추가하세요
    var planTitle = document.getElementById("planTitle").value;
    // 필요한 추가 데이터를 수집하세요
    console.log("Title: " + planTitle);
    // 여행 계획 저장 로직을 여기에 추가
    document.getElementById("myModal").style.display = "none"; // 모달 닫기
});
