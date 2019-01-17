<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
 <!-- TODO: Auto-generated template -->

 <html>
  <body>
   <h2>Pfadfinder_Details</h2>
   <table>
    <tr>
     <th>id</th>
     <th>name</th>
     <th>info</th>
    </tr>
   </table>

   <h2>Pfadfinder_Resources</h2>
   <xsl:for-each select="PfadfinderDB/Resource">
    <tr>
     <td>
      <xsl:value-of select="@id"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@name"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@info"></xsl:value-of>
     </td>
    </tr>
   </xsl:for-each>


   <h2>Pfadfinder_Leaders</h2>
   <table>
    <tr>
     <th>Leader_id</th>
     <th>name</th>
    </tr>
   </table>

   <xsl:for-each select="PfadfinderDB/Leader">
    <tr>
     <td>
      <xsl:value-of select="@id"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@name"></xsl:value-of>
     </td>
    </tr>
   </xsl:for-each>
   
   <h2>Pfadfinder_Invitation</h2>
   <table>
    <tr>
     <th>Invitation_id</th>
     <th>accepted</th>
     <th>Leader_id</th>
    </tr>
   </table>

   <xsl:for-each select="PfadfinderDB/Invitation">
    <tr>
     <td>
      <xsl:value-of select="@id"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@accepted"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@leader-id"></xsl:value-of>
     </td>
    </tr>
   </xsl:for-each>

   <h2>Pfadfinder_Events</h2>
   <table>
    <tr>
     <th>Event_id</th>
     <th>start_date</th>
     <th>end_Date</th>
     <th>name</th>
    </tr>
   </table>

   <xsl:for-each select="PfadfinderDB/Event">
    <tr>
     <td>
      <xsl:value-of select="@id"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@startdate"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@enddate"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@name"></xsl:value-of>
     </td>
    </tr>
   </xsl:for-each>

   <h2>Pfadfinder_Tasks</h2>
   <table>
    <tr>
     <th>Task_id</th>
     <th>due_Date</th>
     <th>name</th>
     <th>info</th>
    </tr>
   </table>

   <xsl:for-each select="PfadfinderDB/Task">
    <tr>
     <td>
      <xsl:value-of select="@id"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@duedate"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="@name"></xsl:value-of>
     </td>
     <td>
      <xsl:value-of select="info"></xsl:value-of>
     </td>
    </tr>
   </xsl:for-each>

  </body>
 </html>

</xsl:template>
</xsl:stylesheet>

<!--
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output encoding="UTF-8" method="html"/>

<xsl:decimal-format name="austria" decimal-separator="," grouping-separator="."/>

<xsl:template match="/PfadfinderDB">
	<html>
		<head>
			<title><xsl:value-of select="Description"/></title>
		</head>
		<body>
			<h1><xsl:value-of select="Description"/></h1>
			
			<h2>Table of Contents</h2>
			<h3>Resources</h3>
			<ol>
				<xsl:for-each select="Resource">
					<li><xsl:value-of select="name"/></li>
				</xsl:for-each>
			</ol>
			<h3>Leaders</h3>
			<ol>
				<xsl:for-each select="Leader">
					<li><xsl:value-of select="name"/></li>
				</xsl:for-each>
			</ol>
			<h3>Invitations</h3>
			<ol>
				<xsl:for-each select="Invitation">
					<li><xsl:value-of select="id"/></li>
				</xsl:for-each>
			</ol>
			<h3>Events</h3>
			<ol>
				<xsl:for-each select="Event">
					<li><xsl:value-of select="id"/></li>
				</xsl:for-each>
			</ol>
			<h3>Tasks</h3>
			<ol>
				<xsl:for-each select="Task">
					<li><xsl:value-of select="id"/></li>
				</xsl:for-each>
			</ol>
			
			<xsl:apply-templates select="Resource" mode="detail"/>
			<xsl:apply-templates select="Leader" mode="detail"/>
			<xsl:apply-templates select="Invitation" mode="detail"/>
			<xsl:apply-templates select="Event" mode="detail"/>
			<xsl:apply-templates select="Task" mode="detail"/>
		</body>
	</html>
</xsl:template>

</xsl:stylesheet>
-->