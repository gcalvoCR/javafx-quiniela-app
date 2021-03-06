USE [master]
GO
/****** Object:  Database [quiniela]    Script Date: 8/20/2018 7:34:41 PM ******/
CREATE DATABASE [quiniela]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'quiniela', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\quiniela.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'quiniela_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\quiniela_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [quiniela] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [quiniela].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [quiniela] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [quiniela] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [quiniela] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [quiniela] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [quiniela] SET ARITHABORT OFF 
GO
ALTER DATABASE [quiniela] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [quiniela] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [quiniela] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [quiniela] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [quiniela] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [quiniela] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [quiniela] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [quiniela] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [quiniela] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [quiniela] SET  DISABLE_BROKER 
GO
ALTER DATABASE [quiniela] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [quiniela] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [quiniela] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [quiniela] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [quiniela] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [quiniela] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [quiniela] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [quiniela] SET RECOVERY FULL 
GO
ALTER DATABASE [quiniela] SET  MULTI_USER 
GO
ALTER DATABASE [quiniela] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [quiniela] SET DB_CHAINING OFF 
GO
ALTER DATABASE [quiniela] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [quiniela] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [quiniela] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [quiniela] SET QUERY_STORE = OFF
GO
USE [quiniela]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [quiniela]
GO
/****** Object:  User [test]    Script Date: 8/20/2018 7:34:41 PM ******/
CREATE USER [test] FOR LOGIN [test] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [test]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [test]
GO
ALTER ROLE [db_datareader] ADD MEMBER [test]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [test]
GO
/****** Object:  Table [dbo].[CRONOGRAMA]    Script Date: 8/20/2018 7:34:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CRONOGRAMA](
	[codigoCronograma] [int] NOT NULL,
	[isoEquipo1] [varchar](50) NOT NULL,
	[isoEquipo2] [varchar](50) NOT NULL,
	[golesEquipo1] [int] NULL,
	[golesEquipo2] [int] NULL,
	[fecha] [date] NOT NULL,
	[fase] [varchar](50) NOT NULL,
	[jugado] [bit] NULL,
	[codigoMundial] [int] NOT NULL,
	[codigoEquipoGanador] [varchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EQUIPO]    Script Date: 8/20/2018 7:34:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EQUIPO](
	[iso] [varchar](50) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[rankingFIFA] [int] NOT NULL,
	[bandera] [image] NULL,
 CONSTRAINT [PK_EQUIPOS] PRIMARY KEY CLUSTERED 
(
	[iso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GRUPO]    Script Date: 8/20/2018 7:34:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GRUPO](
	[codigoGrupo] [varchar](50) NOT NULL,
	[nombreGrupo] [varchar](50) NOT NULL,
	[codigoMundial] [int] NOT NULL,
	[isoEquipo1] [varchar](50) NOT NULL,
	[isoEquipo2] [varchar](50) NOT NULL,
	[isoEquipo3] [varchar](50) NOT NULL,
	[isoEquipo4] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LIGA]    Script Date: 8/20/2018 7:34:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LIGA](
	[nombreLiga] [varchar](50) NOT NULL,
	[fechaCreacion] [date] NOT NULL,
	[estatus] [bit] NOT NULL,
	[privada] [bit] NOT NULL,
	[codigoMundial] [int] NOT NULL,
 CONSTRAINT [PK_LIGA] PRIMARY KEY CLUSTERED 
(
	[nombreLiga] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MUNDIAL]    Script Date: 8/20/2018 7:34:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MUNDIAL](
	[codigoMundial] [int] NOT NULL,
	[fecha] [date] NOT NULL,
	[paisOrganizador] [varchar](50) NOT NULL,
	[estado] [bit] NOT NULL,
 CONSTRAINT [PK_MUNDIAL1] PRIMARY KEY CLUSTERED 
(
	[codigoMundial] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PREDICCION2]    Script Date: 8/20/2018 7:34:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PREDICCION2](
	[llave] [varchar](50) NOT NULL,
	[codigoPrediccion] [int] NULL,
	[codigoMundial] [int] NULL,
	[golesEquipo1] [int] NULL,
	[golesEquipo2] [int] NULL,
	[codigoEquipoGanador] [varchar](50) NULL,
	[usuario] [varchar](50) NULL,
 CONSTRAINT [PK_PREDICCION2] PRIMARY KEY CLUSTERED 
(
	[llave] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USUARIO]    Script Date: 8/20/2018 7:34:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USUARIO](
	[correo] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[rol] [int] NOT NULL,
	[nombreUsuario] [varchar](50) NOT NULL,
	[apellidoUsuario] [varchar](50) NOT NULL,
	[avatar] [image] NOT NULL,
	[usuario] [varchar](50) NOT NULL,
	[puntos] [int] NOT NULL,
	[equipoFavorito] [varchar](50) NOT NULL,
	[nombreLigaPrivada] [varchar](50) NULL,
	[nombreLigaPublica] [varchar](50) NULL,
 CONSTRAINT [PK_USUARIO1_1] PRIMARY KEY CLUSTERED 
(
	[usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (1, N'ALB', N'ABW', NULL, NULL, CAST(N'2018-08-24' AS Date), N'Grupo A', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (2, N'ARE', N'ARG', NULL, NULL, CAST(N'2018-08-24' AS Date), N'Grupo A', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (3, N'ALB', N'ARE', NULL, NULL, CAST(N'2018-08-28' AS Date), N'Grupo A', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (4, N'ABW', N'ARG', NULL, NULL, CAST(N'2018-08-28' AS Date), N'Grupo A', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (5, N'ALB', N'ARG', NULL, NULL, CAST(N'2018-09-02' AS Date), N'Grupo A', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (6, N'ABW', N'ARE', NULL, NULL, CAST(N'2018-09-02' AS Date), N'Grupo A', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (7, N'ARM', N'AUT', NULL, NULL, CAST(N'2018-08-25' AS Date), N'Grupo B', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (8, N'BEL', N'BEN', NULL, NULL, CAST(N'2018-08-25' AS Date), N'Grupo B', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (9, N'ARM', N'BEL', NULL, NULL, CAST(N'2018-08-29' AS Date), N'Grupo B', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (10, N'AUT', N'BEN', NULL, NULL, CAST(N'2018-08-29' AS Date), N'Grupo B', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (11, N'ARM', N'BEN', NULL, NULL, CAST(N'2018-09-03' AS Date), N'Grupo B', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (12, N'AUT', N'BEL', NULL, NULL, CAST(N'2018-09-03' AS Date), N'Grupo B', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (13, N'BFA', N'BGR', NULL, NULL, CAST(N'2018-08-26' AS Date), N'Grupo C', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (14, N'BLR', N'BOL', NULL, NULL, CAST(N'2018-08-26' AS Date), N'Grupo C', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (15, N'BFA', N'BLR', NULL, NULL, CAST(N'2018-08-30' AS Date), N'Grupo C', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (16, N'BGR', N'BOL', NULL, NULL, CAST(N'2018-08-30' AS Date), N'Grupo C', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (17, N'BFA', N'BOL', NULL, NULL, CAST(N'2018-09-04' AS Date), N'Grupo C', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (18, N'BGR', N'BLR', NULL, NULL, CAST(N'2018-09-04' AS Date), N'Grupo C', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (19, N'BRA', N'CAN', NULL, NULL, CAST(N'2018-08-27' AS Date), N'Grupo D', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (20, N'CHE', N'CHL', NULL, NULL, CAST(N'2018-08-27' AS Date), N'Grupo D', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (21, N'BRA', N'CHE', NULL, NULL, CAST(N'2018-08-31' AS Date), N'Grupo D', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (22, N'CAN', N'CHL', NULL, NULL, CAST(N'2018-08-31' AS Date), N'Grupo D', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (23, N'BRA', N'CHL', NULL, NULL, CAST(N'2018-09-05' AS Date), N'Grupo D', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (24, N'CAN', N'CHE', NULL, NULL, CAST(N'2018-09-05' AS Date), N'Grupo D', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (25, N'CHN', N'CIV', NULL, NULL, CAST(N'2018-08-28' AS Date), N'Grupo E', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (26, N'CMR', N'COD', NULL, NULL, CAST(N'2018-08-28' AS Date), N'Grupo E', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (27, N'CHN', N'CMR', NULL, NULL, CAST(N'2018-09-01' AS Date), N'Grupo E', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (28, N'CIV', N'COD', NULL, NULL, CAST(N'2018-09-01' AS Date), N'Grupo E', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (29, N'CHN', N'COD', NULL, NULL, CAST(N'2018-09-06' AS Date), N'Grupo E', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (30, N'CIV', N'CMR', NULL, NULL, CAST(N'2018-09-06' AS Date), N'Grupo E', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (31, N'COL', N'CPV', NULL, NULL, CAST(N'2018-08-29' AS Date), N'Grupo F', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (32, N'CRI', N'CUW', NULL, NULL, CAST(N'2018-08-29' AS Date), N'Grupo F', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (33, N'COL', N'CRI', NULL, NULL, CAST(N'2018-09-02' AS Date), N'Grupo F', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (34, N'CPV', N'CUW', NULL, NULL, CAST(N'2018-09-02' AS Date), N'Grupo F', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (35, N'COL', N'CUW', NULL, NULL, CAST(N'2018-09-07' AS Date), N'Grupo F', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (36, N'CPV', N'CRI', NULL, NULL, CAST(N'2018-09-07' AS Date), N'Grupo F', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (37, N'CYP', N'CZE', NULL, NULL, CAST(N'2018-08-30' AS Date), N'Grupo G', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (38, N'DEU', N'DNK', NULL, NULL, CAST(N'2018-08-30' AS Date), N'Grupo G', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (39, N'CYP', N'DEU', NULL, NULL, CAST(N'2018-09-03' AS Date), N'Grupo G', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (40, N'CZE', N'DNK', NULL, NULL, CAST(N'2018-09-03' AS Date), N'Grupo G', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (41, N'CYP', N'DNK', NULL, NULL, CAST(N'2018-09-08' AS Date), N'Grupo G', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (42, N'CZE', N'DEU', NULL, NULL, CAST(N'2018-09-08' AS Date), N'Grupo G', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (43, N'DZA', N'ECU', NULL, NULL, CAST(N'2018-08-31' AS Date), N'Grupo H', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (44, N'EGY', N'ENG', NULL, NULL, CAST(N'2018-08-31' AS Date), N'Grupo H', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (45, N'DZA', N'EGY', NULL, NULL, CAST(N'2018-09-04' AS Date), N'Grupo H', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (46, N'ECU', N'ENG', NULL, NULL, CAST(N'2018-09-04' AS Date), N'Grupo H', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (47, N'DZA', N'ENG', NULL, NULL, CAST(N'2018-09-09' AS Date), N'Grupo H', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (48, N'ECU', N'EGY', NULL, NULL, CAST(N'2018-09-09' AS Date), N'Grupo H', NULL, 2018, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (1, N'ALB', N'ABW', NULL, NULL, CAST(N'2022-08-06' AS Date), N'Grupo A', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (2, N'ARE', N'ARG', NULL, NULL, CAST(N'2022-08-06' AS Date), N'Grupo A', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (3, N'ALB', N'ARE', NULL, NULL, CAST(N'2022-08-10' AS Date), N'Grupo A', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (4, N'ABW', N'ARG', NULL, NULL, CAST(N'2022-08-10' AS Date), N'Grupo A', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (5, N'ALB', N'ARG', NULL, NULL, CAST(N'2022-08-15' AS Date), N'Grupo A', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (6, N'ABW', N'ARE', NULL, NULL, CAST(N'2022-08-15' AS Date), N'Grupo A', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (7, N'ARM', N'AUT', NULL, NULL, CAST(N'2022-08-07' AS Date), N'Grupo B', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (8, N'BEL', N'BEN', NULL, NULL, CAST(N'2022-08-07' AS Date), N'Grupo B', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (9, N'ARM', N'BEL', NULL, NULL, CAST(N'2022-08-11' AS Date), N'Grupo B', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (10, N'AUT', N'BEN', NULL, NULL, CAST(N'2022-08-11' AS Date), N'Grupo B', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (11, N'ARM', N'BEN', NULL, NULL, CAST(N'2022-08-16' AS Date), N'Grupo B', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (12, N'AUT', N'BEL', NULL, NULL, CAST(N'2022-08-16' AS Date), N'Grupo B', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (13, N'BFA', N'BGR', NULL, NULL, CAST(N'2022-08-08' AS Date), N'Grupo C', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (14, N'BLR', N'BOL', NULL, NULL, CAST(N'2022-08-08' AS Date), N'Grupo C', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (15, N'BFA', N'BLR', NULL, NULL, CAST(N'2022-08-12' AS Date), N'Grupo C', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (16, N'BGR', N'BOL', NULL, NULL, CAST(N'2022-08-12' AS Date), N'Grupo C', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (17, N'BFA', N'BOL', NULL, NULL, CAST(N'2022-08-17' AS Date), N'Grupo C', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (18, N'BGR', N'BLR', NULL, NULL, CAST(N'2022-08-17' AS Date), N'Grupo C', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (19, N'BRA', N'CAN', NULL, NULL, CAST(N'2022-08-09' AS Date), N'Grupo D', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (20, N'CHE', N'CHL', NULL, NULL, CAST(N'2022-08-09' AS Date), N'Grupo D', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (21, N'BRA', N'CHE', NULL, NULL, CAST(N'2022-08-13' AS Date), N'Grupo D', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (22, N'CAN', N'CHL', NULL, NULL, CAST(N'2022-08-13' AS Date), N'Grupo D', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (23, N'BRA', N'CHL', NULL, NULL, CAST(N'2022-08-18' AS Date), N'Grupo D', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (24, N'CAN', N'CHE', NULL, NULL, CAST(N'2022-08-18' AS Date), N'Grupo D', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (25, N'CHN', N'CIV', NULL, NULL, CAST(N'2022-08-10' AS Date), N'Grupo E', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (26, N'CMR', N'COD', NULL, NULL, CAST(N'2022-08-10' AS Date), N'Grupo E', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (27, N'CHN', N'CMR', NULL, NULL, CAST(N'2022-08-14' AS Date), N'Grupo E', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (28, N'CIV', N'COD', NULL, NULL, CAST(N'2022-08-14' AS Date), N'Grupo E', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (29, N'CHN', N'COD', NULL, NULL, CAST(N'2022-08-19' AS Date), N'Grupo E', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (30, N'CIV', N'CMR', NULL, NULL, CAST(N'2022-08-19' AS Date), N'Grupo E', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (31, N'COL', N'CPV', NULL, NULL, CAST(N'2022-08-11' AS Date), N'Grupo F', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (32, N'CRI', N'CUW', NULL, NULL, CAST(N'2022-08-11' AS Date), N'Grupo F', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (33, N'COL', N'CRI', NULL, NULL, CAST(N'2022-08-15' AS Date), N'Grupo F', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (34, N'CPV', N'CUW', NULL, NULL, CAST(N'2022-08-15' AS Date), N'Grupo F', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (35, N'COL', N'CUW', NULL, NULL, CAST(N'2022-08-20' AS Date), N'Grupo F', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (36, N'CPV', N'CRI', NULL, NULL, CAST(N'2022-08-20' AS Date), N'Grupo F', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (37, N'CYP', N'CZE', NULL, NULL, CAST(N'2022-08-12' AS Date), N'Grupo G', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (38, N'DEU', N'DNK', NULL, NULL, CAST(N'2022-08-12' AS Date), N'Grupo G', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (39, N'CYP', N'DEU', NULL, NULL, CAST(N'2022-08-16' AS Date), N'Grupo G', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (40, N'CZE', N'DNK', NULL, NULL, CAST(N'2022-08-16' AS Date), N'Grupo G', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (41, N'CYP', N'DNK', NULL, NULL, CAST(N'2022-08-21' AS Date), N'Grupo G', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (42, N'CZE', N'DEU', NULL, NULL, CAST(N'2022-08-21' AS Date), N'Grupo G', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (43, N'DZA', N'ECU', NULL, NULL, CAST(N'2022-08-13' AS Date), N'Grupo H', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (44, N'EGY', N'ENG', NULL, NULL, CAST(N'2022-08-13' AS Date), N'Grupo H', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (45, N'DZA', N'EGY', NULL, NULL, CAST(N'2022-08-17' AS Date), N'Grupo H', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (46, N'ECU', N'ENG', NULL, NULL, CAST(N'2022-08-17' AS Date), N'Grupo H', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (47, N'DZA', N'ENG', NULL, NULL, CAST(N'2022-08-22' AS Date), N'Grupo H', NULL, 2022, NULL)
INSERT [dbo].[CRONOGRAMA] ([codigoCronograma], [isoEquipo1], [isoEquipo2], [golesEquipo1], [golesEquipo2], [fecha], [fase], [jugado], [codigoMundial], [codigoEquipoGanador]) VALUES (48, N'ECU', N'EGY', NULL, NULL, CAST(N'2022-08-22' AS Date), N'Grupo H', NULL, 2022, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ABW', N'ARY de Macedonia', 71, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ALB', N'Albania', 58, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ARE', N'Emiratos Arabes Unidos', 77, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ARG', N'Argentina', 5, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ARM', N'Armenia', 100, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'AUT', N'Austria', 26, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'BEL', N'Belgica', 3, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'BEN', N'Benín', 88, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'BFA', N'Burkina Faso', 52, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'BGR', N'Bulgaria', 49, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'BLR', N'Bielorrusia', 78, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'BOL', N'Bolivia', 59, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'BRA', N'Brasil', 2, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CAN', N'Canadá', 80, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CHE', N'Suiza', 6, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CHL', N'Chile', 9, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CHN', N'RP de China', 75, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CIV', N'Costa de Marfil', 68, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CMR', N'Camerún', 50, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'COD', N'Congo', 83, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'COL', N'Colombia', 16, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CPV', N'Cabo Verde', 65, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CRI', N'Costa Rica', 23, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CUW', N'Curazao', 81, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CYP', N'Chipre', 87, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'CZE', N'República Checa', 46, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'DEU', N'Alemania', 1, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'DNK', N'Dinamarca', 12, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'DZA', N'Argelia', 66, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ECU', N'Ecuador', 60, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'EGY', N'Egipto', 45, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ENG', N'Inglaterra', 13, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ESP', N'España', 10, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'EST', N'Estonia', 94, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'FIN', N'Finlandia', 63, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'FRA', N'Francia', 7, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'FRO', N'Islas Feroe', 90, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'GEO', N'Georgia', 96, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'GHA', N'Ghana', 47, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'GIN', N'Guinea', 69, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'GRC', N'Grecia', 44, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'HND', N'Honduras', 62, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'HUN', N'Hungría', 51, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'IND', N'India', 97, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'IRL', N'República de Irlanda', 31, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'IRQ', N'Irak', 89, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ISR', N'Israel', 93, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'JAM', N'Jamaica', 54, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'JPN', N'Japón', 61, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'KGZ', N'República Kirguisa', 92, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'KOR', N'República de Corea', 57, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'LBN', N'Líbano', 79, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'LUX', N'Luxemburgo', 86, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'MAR', N'Marruecos', 41, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'MEX', N'México', 15, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'MLI', N'Mali', 64, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'MNE', N'Montenegro', 43, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'NGA', N'Nigeria', 48, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'NIR', N'Irlanda del Norte', 29, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'NLD', N'Países Bajos', 17, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'NOR', N'Noruega', 53, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'OMN', N'Omán', 84, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'PAN', N'Panamá', 55, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'PAR', N'Paraguay', 32, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'PER', N'Perú', 11, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'POL', N'Polonia', 8, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'POR', N'Portugal', 4, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'PSE', N'Palestina', 99, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'QAT', N'Qatar', 98, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ROU', N'Rumanía', 30, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'RUS', N'Rusia', 70, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'SAU', N'Arabia Saudí', 67, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'SCT', N'Escocia', 42, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'SEN', N'Senegal', 27, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'SLV', N'El Salvador', 72, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'SRB', N'Serbia', 34, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'SVK', N'Eslovaquia', 28, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'SVN', N'Eslovenia', 56, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'SYR', N'Siria', 73, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'TTO', N'Trinidad y Tobago', 91, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'TUN', N'Tunez', 21, 0x6E756C6C)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'UGA', N'Uganda', 82, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'URY', N'Uruguay', 14, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'UZB', N'Uzbekistán', 95, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ZAF', N'Sudáfrica', 74, NULL)
INSERT [dbo].[EQUIPO] ([iso], [nombre], [rankingFIFA], [bandera]) VALUES (N'ZMB', N'Zambia', 76, NULL)
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo A', N'Grupo A', 2018, N'ALB', N'ABW', N'ARE', N'ARG')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo B', N'Grupo B', 2018, N'ARM', N'AUT', N'BEL', N'BEN')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo C', N'Grupo C', 2018, N'BFA', N'BGR', N'BLR', N'BOL')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo D', N'Grupo D', 2018, N'BRA', N'CAN', N'CHE', N'CHL')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo E', N'Grupo E', 2018, N'CHN', N'CIV', N'CMR', N'COD')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo F', N'Grupo F', 2018, N'COL', N'CPV', N'CRI', N'CUW')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo G', N'Grupo G', 2018, N'CYP', N'CZE', N'DEU', N'DNK')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo H', N'Grupo H', 2018, N'DZA', N'ECU', N'EGY', N'ENG')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo A', N'Grupo A', 2022, N'ALB', N'ABW', N'ARE', N'ARG')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo B', N'Grupo B', 2022, N'ARM', N'AUT', N'BEL', N'BEN')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo C', N'Grupo C', 2022, N'BFA', N'BGR', N'BLR', N'BOL')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo D', N'Grupo D', 2022, N'BRA', N'CAN', N'CHE', N'CHL')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo E', N'Grupo E', 2022, N'CHN', N'CIV', N'CMR', N'COD')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo F', N'Grupo F', 2022, N'COL', N'CPV', N'CRI', N'CUW')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo G', N'Grupo G', 2022, N'CYP', N'CZE', N'DEU', N'DNK')
INSERT [dbo].[GRUPO] ([codigoGrupo], [nombreGrupo], [codigoMundial], [isoEquipo1], [isoEquipo2], [isoEquipo3], [isoEquipo4]) VALUES (N'Grupo H', N'Grupo H', 2022, N'DZA', N'ECU', N'EGY', N'ENG')
INSERT [dbo].[LIGA] ([nombreLiga], [fechaCreacion], [estatus], [privada], [codigoMundial]) VALUES (N'Premier', CAST(N'2018-08-23' AS Date), 1, 0, 2018)
INSERT [dbo].[MUNDIAL] ([codigoMundial], [fecha], [paisOrganizador], [estado]) VALUES (2018, CAST(N'2018-08-23' AS Date), N'Rusia', 1)
INSERT [dbo].[MUNDIAL] ([codigoMundial], [fecha], [paisOrganizador], [estado]) VALUES (2022, CAST(N'2022-08-05' AS Date), N'Polonia', 0)
INSERT [dbo].[USUARIO] ([correo], [password], [rol], [nombreUsuario], [apellidoUsuario], [avatar], [usuario], [puntos], [equipoFavorito], [nombreLigaPrivada], [nombreLigaPublica]) VALUES (N'admin@futbolito.com', N'admin', 1, N'admin', N'admin', 0x61646D696E, N'admin', 0, N'CRI', N'Premier', NULL)
INSERT [dbo].[USUARIO] ([correo], [password], [rol], [nombreUsuario], [apellidoUsuario], [avatar], [usuario], [puntos], [equipoFavorito], [nombreLigaPrivada], [nombreLigaPublica]) VALUES (N'aosante@gmail.com', N'123', 2, N'Andres', N'Osante', 0x416E647265736F, N'Andres100', 100, N'ARM', N'noExiste', N'2018')
INSERT [dbo].[USUARIO] ([correo], [password], [rol], [nombreUsuario], [apellidoUsuario], [avatar], [usuario], [puntos], [equipoFavorito], [nombreLigaPrivada], [nombreLigaPublica]) VALUES (N'gcalvo@gmail.com', N'123', 2, N'Gabriel', N'Calvo', 0x6761627269656C, N'gcalvo', 10, N'CRI', N'Premier', NULL)
INSERT [dbo].[USUARIO] ([correo], [password], [rol], [nombreUsuario], [apellidoUsuario], [avatar], [usuario], [puntos], [equipoFavorito], [nombreLigaPrivada], [nombreLigaPublica]) VALUES (N'jcubana@gmail.com', N'123', 2, N'Juana', N'La Cubana', 0x6A75616E61437562616E61, N'Juana100', 100, N'BEL', N'noExiste', N'2018')
INSERT [dbo].[USUARIO] ([correo], [password], [rol], [nombreUsuario], [apellidoUsuario], [avatar], [usuario], [puntos], [equipoFavorito], [nombreLigaPrivada], [nombreLigaPublica]) VALUES (N'mbrenes@gmail.com', N'123', 2, N'Manuel', N'Brenes', 0x4D616E75656C696E, N'manuel100', 100, N'CRI', N'noExiste', N'2018')
INSERT [dbo].[USUARIO] ([correo], [password], [rol], [nombreUsuario], [apellidoUsuario], [avatar], [usuario], [puntos], [equipoFavorito], [nombreLigaPrivada], [nombreLigaPublica]) VALUES (N'mmonge@gmail.com', N'123', 2, N'Marta', N'Monge', 0x4D617274616E, N'marta100', 100, N'BEN', N'noExiste', N'2018')
INSERT [dbo].[USUARIO] ([correo], [password], [rol], [nombreUsuario], [apellidoUsuario], [avatar], [usuario], [puntos], [equipoFavorito], [nombreLigaPrivada], [nombreLigaPublica]) VALUES (N'mangulo@gmail.com', N'123', 2, N'Miguel', N'Angulo', 0x6D696775656C69746F, N'miguelito', 100, N'BRA', N'Premier', N'2018')
INSERT [dbo].[USUARIO] ([correo], [password], [rol], [nombreUsuario], [apellidoUsuario], [avatar], [usuario], [puntos], [equipoFavorito], [nombreLigaPrivada], [nombreLigaPublica]) VALUES (N'soviedos@gmail.com', N'123', 2, N'Sergio', N'Oviedo', 0x73657267696F, N'soviedos', 100, N'CRI', N'Premier', NULL)
ALTER TABLE [dbo].[CRONOGRAMA]  WITH CHECK ADD  CONSTRAINT [FK_CRONOGRAMA1_EQUIPO1] FOREIGN KEY([isoEquipo1])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[CRONOGRAMA] CHECK CONSTRAINT [FK_CRONOGRAMA1_EQUIPO1]
GO
ALTER TABLE [dbo].[CRONOGRAMA]  WITH CHECK ADD  CONSTRAINT [FK_CRONOGRAMA1_EQUIPO2] FOREIGN KEY([isoEquipo2])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[CRONOGRAMA] CHECK CONSTRAINT [FK_CRONOGRAMA1_EQUIPO2]
GO
ALTER TABLE [dbo].[CRONOGRAMA]  WITH CHECK ADD  CONSTRAINT [FK_CRONOGRAMA1_EQUIPOGanador] FOREIGN KEY([codigoEquipoGanador])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[CRONOGRAMA] CHECK CONSTRAINT [FK_CRONOGRAMA1_EQUIPOGanador]
GO
ALTER TABLE [dbo].[CRONOGRAMA]  WITH CHECK ADD  CONSTRAINT [FK_CRONOGRAMA1_MUNDIAL] FOREIGN KEY([codigoMundial])
REFERENCES [dbo].[MUNDIAL] ([codigoMundial])
GO
ALTER TABLE [dbo].[CRONOGRAMA] CHECK CONSTRAINT [FK_CRONOGRAMA1_MUNDIAL]
GO
ALTER TABLE [dbo].[EQUIPO]  WITH CHECK ADD  CONSTRAINT [FK_EQUIPOS_EQUIPOS] FOREIGN KEY([iso])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[EQUIPO] CHECK CONSTRAINT [FK_EQUIPOS_EQUIPOS]
GO
ALTER TABLE [dbo].[GRUPO]  WITH CHECK ADD  CONSTRAINT [FK_GRUPO_MUNDIAL] FOREIGN KEY([codigoMundial])
REFERENCES [dbo].[MUNDIAL] ([codigoMundial])
GO
ALTER TABLE [dbo].[GRUPO] CHECK CONSTRAINT [FK_GRUPO_MUNDIAL]
GO
ALTER TABLE [dbo].[GRUPO]  WITH CHECK ADD  CONSTRAINT [FK_GRUPOS_EQUIPO1] FOREIGN KEY([isoEquipo1])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[GRUPO] CHECK CONSTRAINT [FK_GRUPOS_EQUIPO1]
GO
ALTER TABLE [dbo].[GRUPO]  WITH CHECK ADD  CONSTRAINT [FK_GRUPOS_EQUIPO2] FOREIGN KEY([isoEquipo2])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[GRUPO] CHECK CONSTRAINT [FK_GRUPOS_EQUIPO2]
GO
ALTER TABLE [dbo].[GRUPO]  WITH CHECK ADD  CONSTRAINT [FK_GRUPOS_EQUIPO3] FOREIGN KEY([isoEquipo3])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[GRUPO] CHECK CONSTRAINT [FK_GRUPOS_EQUIPO3]
GO
ALTER TABLE [dbo].[GRUPO]  WITH CHECK ADD  CONSTRAINT [FK_GRUPOS_EQUIPO4] FOREIGN KEY([isoEquipo4])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[GRUPO] CHECK CONSTRAINT [FK_GRUPOS_EQUIPO4]
GO
ALTER TABLE [dbo].[LIGA]  WITH CHECK ADD  CONSTRAINT [FK_LIGA_MUNDIAL] FOREIGN KEY([codigoMundial])
REFERENCES [dbo].[MUNDIAL] ([codigoMundial])
GO
ALTER TABLE [dbo].[LIGA] CHECK CONSTRAINT [FK_LIGA_MUNDIAL]
GO
ALTER TABLE [dbo].[USUARIO]  WITH CHECK ADD  CONSTRAINT [FK_USUARIO_EQUIPO] FOREIGN KEY([equipoFavorito])
REFERENCES [dbo].[EQUIPO] ([iso])
GO
ALTER TABLE [dbo].[USUARIO] CHECK CONSTRAINT [FK_USUARIO_EQUIPO]
GO
USE [master]
GO
ALTER DATABASE [quiniela] SET  READ_WRITE 
GO
