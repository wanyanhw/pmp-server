function mouseOn(_thisElement) {
    let id = _thisElement.id;
    let $element = $("#" + id);
    $element.css("backgroundColor", "rgba(70, 162, 233, 0.3)");
    $element.css("boxShadow", "rgba(70, 162, 233, 0.5) 5px 5px 10px 5px");

}

function mouseOut(_thisElement) {
    let id = _thisElement.id;
    let $element = $("#" + id);
    $element.css("backgroundColor", "transparent");
    $element.css("boxShadow", "none");
}