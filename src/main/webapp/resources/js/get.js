/**
 * 
 */
 	$(function() {
		
		//댓글 가져오기 
		function showModifyModal(rno) {
			$.ajax({
				type: "get",
				url:  appRoot+"/replies/" + rno,
				success: function (reply) {
					$("#reply-rno-input2").val(reply.rno);
					$("#reply-replyer-input2").val(reply.replyer);
					$("#reply-replyerName-input2").val(reply.replyerName);
					$("#reply-reply-textarea2").text(reply.reply);

					// 댓글 작성자와 로그인 유저가 같지 않으면 
					// 수정/삭제 버튼 삭제
					if (userid != reply.replyer) {
						$("#reply-modify-modal")
						.find("#reply-modify-delete-btn-wrapper")
						.hide();	

						$("#reply-reply-textarea2").attr("readonly", "readonly");
					} else {
						$("#reply-modify-modal")
						.find("#reply-modify-delete-btn-wrapper")
						.show();	

						$("#reply-reply-textarea2").removeAttr("readonly");
					}

					$("#reply-modify-modal").modal("show");
				},
				error: function () {
					console.log("댓글 가져오는중 에러 발생  실패");
				}
			})
		}
		
		//댓글보여주는 함수 
		function showReplyList(list){
			// empty 비워주는 이유: 밑에서 append 추가해줘서 댓글이 중복해서 보임 
			var container =$("#reply-list-container").empty();
			
			//html 코드 편하게 작성하는 방법 
			
			for (var reply of list) {
			var replyHTML = `
				<li class="media" style="border : 1px solid gray" id="reply${reply.rno}">
					<div class="media-body p-2">
						<div class="row">
							<div class="col align-self-start">
								<i class="far fa-user"></i><span class="my-4 font-weight-bold"> : ${reply.replyerName}</span>						
							</div>
							<div class="col align-self-end text-right">
								<small>${new Date(reply.replyDate).toISOString().split("T")[0]}</small>
							</div>
						</div>
						<hr style="border:dotted 1px gray">
						<p>${reply.reply}</p>
						<div class="text-right">
							<button id="btn${reply.rno}" data-rno="${reply.rno}" class="btn btn-success btmd">수정/삭제 </button>
						</div>
					</div>
				</li><br>`;
			var replyComponent = $(replyHTML);
			replyComponent.find(".btmd").click(function() {
				showModifyModal($(this).attr("data-rno"));
			});
			container.append(replyComponent);
		}
		
			/*
			//향상된 for문 !
			for (var reply of list) {
			var newItem = $("<li>").addClass("media  mt-2").css("border","1px solid gray")
									.attr("id", "reply" + reply.rno)
									.attr("data-rno", reply.rno);
			var mediaBody = $("<div>").addClass("media-body  p-2");
			newItem.append(mediaBody);
			
			newItem.click(function() {
				showModifyModal($(this).attr("data-rno"));
			});
			mediaBody.append("<span class='col align-self-start p-0'>" + reply.replyer + "</span>")
			        .append("<small class='col align-self-end text-right'>" + new Date(reply.replyDate).toISOString().split("T")[0] + "</small>")
				    .append("<hr class='m-0'>").css("border","1px solid gray")
				   // .append("<sup class='col align-self-end text-right'>" + "클릭해서 수정삭제하기 "+ "</sup>")
				    .append("<p class='p-2'>" + reply.reply + "</p>");
				   
			
			container.append(newItem);
			}
			*/
		}
		
		//댓글 목록 가져오기 
		function getReplyList() {
			$.ajax({
				type: "get",
				url: appRoot+"/replies/pages/"+boardBno,
				success: function(list) {
					console.log(list);
					showReplyList(list);
				},
				error : function() {
					console.log("댓글 가져오는 중 에러.");
				}
			});
		}
		// 페이지 로딩 후 댓글 목록 가져오는 함수 실행
		getReplyList();
		
		// 댓글 입력 버튼 처리 하기! 
		$("#reply-insert-btn1").click(function() {
			var bno = $("#reply-bno-input1").val();
			var replyer = $("#reply-replyer-input1").val();
			var reply = $("#reply-reply-textarea1").val();
			
			var data = {
				bno: bno,
				replyer: replyer,
				reply: reply
			};
			
			$.ajax({
				type: "post",
				url:  appRoot+"/replies/new",
				data: JSON.stringify(data),
				contentType: "application/json",
				success: function() {
					console.log("입력 성공! ");
					//모달창 닫아주기 
					$("#reply-insert-modal").modal("hide");
					
					//댓글 리스트 가져와~ 
					getReplyList();
					
					// 안내메시지 보여주기 
					$("#alert1").text("새 댓글 입력하였습니다.").addClass("show");
					
				},
				error: function() {
					console.log("입력 실패 ㅠ ");
				}
			});
		});
		
		
		// 수정 버튼클릭할때 일어나는 일
		$("#reply-modify-btn1").click(function(){
			//필요한 값 얻어오기 
			var rno =$("#reply-rno-input2").val();
			var bno = $("#reply-bno-input2").val();
			var reply = $("#reply-reply-textarea2").val();
			var replyer = $("#reply-replyer-input2").val();
			var data = {
					rno: rno,
					bno: bno,
					replyer: replyer,
					reply: reply
				};
				
			$.ajax({
				type : "put",
				url : appRoot+"/replies/" + rno,
				data : JSON.stringify(data),
				contentType : "application/json",
				success : function(){
					console.log("댓글 수정 성공  ! ");
					//모달창 닫아주기 
					$("#reply-modify-modal").modal("hide");
					
					//댓글 리스트 가져와~ 
					getReplyList();
					
					// 안내메시지 보여주기 
					$("#alert1").text("댓글이 수정되었습니다.").addClass("show");
				},
				error : function(){
					console.log("댓글 수정 실패 !!  ! ");
				}
			})
		})
		
		//댓글 삭제하기 버튼클릭할때 일어나는 일
		$("#reply-delete-btn1").click(function(){
			var check = confirm("댓글을 삭제하시겠습니까? ");
			
			if(check){
				var rno = $("#reply-rno-input2").val();
				var replyer = $("#reply-replyer-input2").val();

				var data = {
					rno : rno,
					replyer: replyer
				}

				$.ajax({
					type : "delete",
					url :  appRoot+"/replies/" + rno,
					data : JSON.stringify(data),
					contentType : "application/json",
					success : function(){
						console.log("댓글 삭제  성공  ! ");
						//모달창 닫아주기 
						$("#reply-modify-modal").modal("hide");
						
						//댓글 리스트 가져와~ 
						getReplyList();
						
						// 안내메시지 보여주기 
						$("#alert1").text("댓글이 삭제되었습니다.").addClass("show");
					},
					error : function(){
						console.log("댓글 삭제 실패 !!  ! ");
					}
				})
			}
		})
	})