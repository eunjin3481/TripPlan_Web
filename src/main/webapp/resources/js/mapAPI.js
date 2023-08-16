var arr = new Array();

function initMap() {
  const map = new google.maps.Map(document.getElementById("map"), {
    center: {
      lat: 37.5400456,
      lng: 126.9921017
    },
    zoom: 10,
  });

  var image = "http://maps.google.com/mapfiles/ms/icons/red-dot.png";
  for (var i = 0; i < arr.length; i++) {
    var place = arr[i];
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({
      'address': place
    }, function (results, status) {
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
        map: map,
        icon: image, // 마커로 사용할 이미지(변수)
        position: results[0].geometry.location,
        label: i + 1,
      });
    })
  }
}

function openPopup1() {
  window.open('../place/place_add', 'subpage', 'width=400, height=400');
}

function openPopup2(placeId) {
  window.open('../place/place_modify?placeId=' + placeId, 'subpage', 'width=400, height=400');
}

// "추가" 버튼 클릭 시 입력 폼 생성 및 표시
function showAddForm() {
	document.getElementById("addFormContainer").style.display = "block";
}        