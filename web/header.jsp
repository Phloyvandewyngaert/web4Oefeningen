<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
    <img alt="Banner" src="images/banner.jpg">
    <h1><span>Chat App</span></h1>
    <nav>
        <ul>
            <c:choose>
                <c:when test="${param.title=='Home'}">
                    <li id="actual"><a href="Controller">Home</a></li>
                    <c:if test="${thisPerson!=null}"> <%-- als persoon is ingelogd --%>
                        <li><a href="Controller?action=NaarChat">Chat</a></li>
                    </c:if>
                    <li><a href="Controller?action=NaarBlog">Blog</a></li>
                    <li><a href="Controller?action=NaarLes">Les</a></li>
                    <li><a href="Controller?action=NaarCadeau">Cadeau</a></li>
                </c:when>

                <c:when test="${param.title=='Chat'}">
                    <li><a href="Controller">Home</a></li>
                    <li id="actual"><a href="Controller?action=NaarChat">Chat</a></li>
                    <li><a href="Controller?action=NaarBlog">Blog</a></li>
                    <li><a href="Controller?action=NaarLes">Les</a></li>
                    <li><a href="Controller?action=NaarCadeau">Cadeau</a></li>
                </c:when>

                <c:when test="${param.title=='Blog'}">
                    <li><a href="Controller">Home</a></li>
                    <c:if test="${thisPerson!=null}">
                        <li><a href="Controller?action=NaarChat">Chat</a></li>
                    </c:if>
                    <li id="actual"><a href="Controller?action=NaarBlog">Blog</a></li>
                    <li><a href="Controller?action=NaarLes">Les</a></li>
                    <li><a href="Controller?action=NaarCadeau">Cadeau</a></li>
                </c:when>

                <c:when test="${param.title=='Les'}">
                    <li><a href="Controller">Home</a></li>
                    <c:if test="${thisPerson!=null}">
                        <li><a href="Controller?action=NaarChat">Chat</a></li>
                    </c:if>
                    <li><a href="Controller?action=NaarBlog">Blog</a></li>
                    <li><a href="Controller?action=NaarCadeau">Cadeau</a></li>
                    <li id="actual"><a href="Controller?action=NaarLes">Les</a></li>
                </c:when>

                <c:when test="${param.title=='Cadeau'}">
                    <li><a href="Controller">Home</a></li>
                    <c:if test="${thisPerson!=null}">
                        <li><a href="Controller?action=NaarChat">Chat</a></li>
                    </c:if>
                    <li><a href="Controller?action=NaarBlog">Blog</a></li>
                    <li><a href="Controller?action=NaarLes">les</a></li>
                    <li id="actual"><a href="Controller?action=NaarCadeau">Cadeau</a></li>
                </c:when>

                <c:otherwise>
                    <li><a href="Controller">Home</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
    <h2> ${param.title} </h2>
</header>