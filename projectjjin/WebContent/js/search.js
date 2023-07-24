/*
  초성검색 부분		자동완성 검색기능
*/
      const CHO_HANGUL = [
        'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ',
        'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ',
        'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ',
        'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ',
    ];

    const HANGUL_START_CHARCODE = "가".charCodeAt();

    const CHO_PERIOD = Math.floor("까".charCodeAt() - "가".charCodeAt());
    const JUNG_PERIOD = Math.floor("개".charCodeAt() - "가".charCodeAt());

    function combine(cho, jung, jong) {
        return String.fromCharCode(
            HANGUL_START_CHARCODE + cho * CHO_PERIOD + jung * JUNG_PERIOD + jong
        );
    }

    function makeRegexByCho(search = "") {
        const regex = CHO_HANGUL.reduce(
            (acc, cho, index) =>
                acc.replace(
                    new RegExp(cho, "g"),
                    `[${combine(index, 0, 0)}-${combine(index + 1, 0, -1)}]`
                ),
            search
        );

        return new RegExp(`(${regex})`, "g");
    }

    function includeByCho(search, targetWord) {
        return makeRegexByCho(search).test(targetWord);
    }

    const dataList = ["레드북", "그날들", "영웅", "맘마미아", "웃는남자", "데스노트", "시카고", "신과함께"];

    $(document).ready(function() {
        const $search = $("#search");
        const $autoComplete = $(".autocomplete");

        let nowIndex = 0;

        $search.on("keyup", function(event) {
            const value = $search.val().trim();

            const matchDataList = value
                ? dataList.filter((label) => includeByCho(value, label))
                : [];

            switch (event.keyCode) {
                case 38:
                    nowIndex = Math.max(nowIndex - 1, 0);
                    break;
                case 40:
                    nowIndex = Math.min(nowIndex + 1, matchDataList.length - 1);
                    break;
                case 13:
                    $("#search").val(matchDataList[nowIndex] || "");
                    nowIndex = 0;
                    matchDataList.length = 0;
                    break;
                default:
                    nowIndex = 0;

                    break;
            }

            showList(matchDataList, value, nowIndex);
        });

        const showList = function(data, value, nowIndex) {
            const regex = makeRegexByCho(value);

            $autoComplete.html(
                data.map(function(label, index) {
                    return `
                        <div class="${nowIndex === index ? "active" : ""}">
                            ${label.replace(regex, "<mark>$1</mark>")}
                        </div>
                    `;
                }).join("")
            );
        };
});

// 검색 버튼 눌렀을 때
$(function(){
	$('#btn_header_search').click(function(){
		//console.log($('#search').val()+"입니다");
		//alert($('#search').val()+"!!");
		if($('#search').val() == '레드북'){
		location.href="html/subpage1.html";
		}else if($('#search').val() == '그날들'){
		location.href="html/subpage2.html";	
		}else if($('#search').val() == '맘마미아'){
		location.href="html/subpage3.html";	
		}else if($('#search').val() == '영웅'){
		location.href="html/subpage4.html";
		}else if($('#search').val() == '웃는남자'){
		location.href="html/subpage5.html";	
		}else if($('#search').val() == '데스노트'){
		location.href="html/subpage6.html";	
		}else if($('#search').val() == '시카고'){
		location.href="html/subpage7.html";	
		}else if($('#search').val() == '신과함께'){
		location.href="html/subpage8.html";	
		}
	});
});



