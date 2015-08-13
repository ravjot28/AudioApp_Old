<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<sj:head jqueryui="true" />
<sb:head />
<div style="visibility: hidden">
	<sj:dialog id="ErrorDialog" title=" " modal="true" width="500"
		resizable="false"
		buttons="{
        'Ok':function() {
        $(this).dialog('close');
        }
        }">
		<h6>
			<s:actionerror theme="bootstrap" />
			<s:fielderror theme="bootstrap" />
			<s:actionmessage theme="bootstrap" />
		</h6>
	</sj:dialog>
</div>
