function search() {
    var searchInput = document.getElementById("searchInput").value;
    var rows = document.getElementsByTagName("tr");

    for (var i = 1; i < rows.length; i++) {
        var titleCell = rows[i].getElementsByTagName("td")[1];
        var title = titleCell.textContent || titleCell.innerText;
        var lowerCaseTitle = title.toLowerCase();
        var lowerCaseSearchInput = searchInput.toLowerCase();

        if (lowerCaseTitle.indexOf(lowerCaseSearchInput) > -1) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}

function refreshPage() {
    location.reload();
}