<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h4 class="modal-title">Q&amp;A</h4>
						<div class="panel-group">
							<div class="panel panel-default">
								<div class="panel-heading">
									<div class="panel-title">
										<span>
											<input type="checkbox" name="">
											<a data-toggle="collapse" href="#collapse1" class="question">&nbsp;Collapsible panel</a>
										</span>
									</div>
								</div>
								<div id="collapse1" class="panel-collapse collapse">
									<form action="" method="">
										<div class="panel-body">
											<textarea></textarea>
										</div>
										<div class="panel-footer">
											<input type="submit" name="" value="등록">
										</div>
									</form>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading" data-toggle="collapse" href="#collapse2">
									<div class="panel-title">
										<span>
											<input type="checkbox" name="">
											<a data-toggle="collapse" href="#collapse2" class="question">&nbsp;Collapsible panel</a>
										</span>
									</div>
								</div>
								<div id="collapse2" class="panel-collapse collapse">
									<form action="" method="">
										<div class="panel-body">
											<textarea></textarea>
										</div>
										<div class="panel-footer">
											<input type="submit" name="" value="등록">
										</div>
									</form>
								</div>
							</div>

							<div class="panel panel-default">
								<div class="panel-heading" data-toggle="collapse" href="#collapse3">
									<div class="panel-title">
										<span>
											<input type="checkbox" name="">
											<a data-toggle="collapse" href="#collapse3" class="question">&nbsp;Collapsible panel</a>
										</span>
									</div>
								</div>
								<div id="collapse3" class="panel-collapse collapse">
									<form action="" method="">
										<div class="panel-body">
											<textarea></textarea>
										</div>
										<div class="panel-footer">
											<input type="submit" name="" value="등록">
										</div>
									</form>
								</div>
							</div>
							<input type="button" value="삭제" name="delete_btn">
						</div>