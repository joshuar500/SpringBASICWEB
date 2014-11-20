<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">

    // this method of checking if passwords are the same
    // is dangerous because somebody can either have js
    // turned off, or they can manipulate the js so the
    // form still submits

    // after the key is pressed, check passwords match
    // can the form be submitted?
    function onLoad() {
        $("#password").keyup(checkPasswordsMatch);
        $("#confirmPassword").keyup(checkPasswordsMatch);

        $("#details").submit(canSubmit);
    }

    // the user can or cannot submit
    function canSubmit() {
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();

        if (password != confirmPassword) {
            return false;
        } else {
            return true;
        }
    }

    function checkPasswordsMatch() {
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();

        if(password.length > 3 || confirmPassword.length > 3) {
            if (password == confirmPassword) {
                $("#matchpass").text("<fmt:message key='MatchedPasswords.user.password' />");
                $("#matchpass").addClass("valid");
                $("#matchpass").removeClass("error");
            } else {
                $("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password' />");
                $("#matchpass").addClass("error");
                $("#matchpass").removeClass("valid");
            }
        }
    }

    $(document).ready(onLoad);

</script>
