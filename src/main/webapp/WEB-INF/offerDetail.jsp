<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>J'Offre</title>
    <link href="css/chat.css" rel="stylesheet">
    <%@ include file="bootstrapIncludes.jsp" %>

</head>
<body>


<a href="#" id="addClass"> Open chat now </a>



<div class="popup-box chat-popup" id="qnimate">
    <div class="popup-head">
        <div class="popup-head-left pull-left"><img src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" alt="iamgurdeeposahan"> Gurdeep Osahan</div>
        <div class="popup-head-right pull-right">
            <div class="btn-group">
                <button class="chat-header-button" data-toggle="dropdown" type="button" aria-expanded="false">
                    <i class="glyphicon glyphicon-cog"></i> </button>
                <ul role="menu" class="dropdown-menu pull-right">
                    <li><a href="#">Media</a></li>
                    <li><a href="#">Block</a></li>
                    <li><a href="#">Clear Chat</a></li>
                    <li><a href="#">Email Chat</a></li>
                </ul>
            </div>

            <button data-widget="remove" id="removeClass" class="chat-header-button pull-right" type="button"><i class="glyphicon glyphicon-off"></i></button>
        </div>
    </div>
    <div class="popup-messages">




        <div class="direct-chat-messages">


            <div class="chat-box-single-line">
                <abbr class="timestamp">October 8th, 2015</abbr>
            </div>


            <!-- Message. Default to the left -->
            <div class="direct-chat-msg doted-border">
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-left">Osahan</span>
                </div>
                <!-- /.direct-chat-info -->
                <img alt="message user image" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class="direct-chat-img"><!-- /.direct-chat-img -->
                <div class="direct-chat-text">
                    Hey bro, how’s everything going ?
                </div>
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-timestamp pull-right">3.36 PM</span>
                </div>
                <div class="direct-chat-info clearfix">
						<span class="direct-chat-img-reply-small pull-left">

						</span>
                    <span class="direct-chat-reply-name">Singh</span>
                </div>
                <!-- /.direct-chat-text -->
            </div>
            <!-- /.direct-chat-msg -->


            <div class="chat-box-single-line">
                <abbr class="timestamp">October 9th, 2015</abbr>
            </div>



            <!-- Message. Default to the left -->
            <div class="direct-chat-msg doted-border">
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-left">Osahan</span>
                </div>
                <!-- /.direct-chat-info -->
                <img alt="iamgurdeeposahan" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class="direct-chat-img"><!-- /.direct-chat-img -->
                <div class="direct-chat-text">
                    Hey bro, how’s everything going ?
                </div>
                <div class="direct-chat-info clearfix">
                    <span class="direct-chat-timestamp pull-right">3.36 PM</span>
                </div>
                <div class="direct-chat-info clearfix">
                    <img alt="iamgurdeeposahan" src="http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class="direct-chat-img big-round">
                    <span class="direct-chat-reply-name">Singh</span>
                </div>
                <!-- /.direct-chat-text -->
            </div>
            <!-- /.direct-chat-msg -->






        </div>









    </div>
    <div class="popup-messages-footer">
        <textarea id="status_message" placeholder="Type a message..." rows="10" cols="40" name="message"></textarea>
        <div class="btn-footer">
            <button class="bg_none"><i class="glyphicon glyphicon-film"></i> </button>
            <button class="bg_none"><i class="glyphicon glyphicon-camera"></i> </button>
            <button class="bg_none"><i class="glyphicon glyphicon-paperclip"></i> </button>
            <button class="bg_none pull-right"><i class="glyphicon glyphicon-thumbs-up"></i> </button>
        </div>
    </div>
</div>





<%@ include file="bootstrapIncludeLast.jsp" %>

</body>
</html>
