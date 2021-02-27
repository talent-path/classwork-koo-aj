"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.Knight = void 0;
var ChessPiece_1 = require("./ChessPiece");
var Piece_1 = require("./Piece");
var Knight = /** @class */ (function (_super) {
    __extends(Knight, _super);
    function Knight(isWhite) {
        var _this = _super.call(this, Piece_1.PieceType.Knight, isWhite) || this;
        _this.generateMoves = function (moveOn, loc) {
            var knightsMoves = [];
            var knightsDirections = [];
            // first we know that the first move that the pawn can make is 1 or 2
            // after the first move it cannot go two but ONLY 1
            // we must check if the diagonal down has a piece that we can capture
            // if it goes all the way to the row we can switch to a desired pieace.
            knightsDirections.push({ row: 2, col: -1 });
            knightsDirections.push({ row: 2, col: 1 });
            knightsDirections.push({ row: 1, col: -2 });
            knightsDirections.push({ row: 1, col: 2 });
            knightsDirections.push({ row: -2, col: -1 });
            knightsDirections.push({ row: -2, col: 1 });
            knightsDirections.push({ row: -1, col: -2 });
            knightsDirections.push({ row: -1, col: 2 });
            for (var _i = 0, knightsDirections_1 = knightsDirections; _i < knightsDirections_1.length; _i++) {
                var direction = knightsDirections_1[_i];
                var directionMoves = Knight.jumpPiece(moveOn, loc, direction, _this.isWhite);
                knightsMoves.push.apply(knightsMoves, directionMoves);
            }
            return knightsMoves;
        };
        return _this;
    }
    Knight.isOnBoard = function (loc) {
        return loc.col >= 0 && loc.col < 8 && loc.row >= 0 && loc.row < 8;
    };
    // xxxx
    // xxxx
    // xxxp
    // xxpr
    Knight.jumpPiece = function (moveOn, loc, dir, isWhite) {
        var allMoves = [];
        var currentLoc = { row: loc.row + dir.row, col: loc.col + dir.col };
        if (Knight.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
            allMoves.push({ from: loc, to: currentLoc });
        }
        if (Knight.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) !== null) {
            if (moveOn.pieceAt(currentLoc).isWhite != isWhite) {
                allMoves.push({ from: loc, to: currentLoc });
            }
        }
        return allMoves;
    };
    return Knight;
}(ChessPiece_1.ChessPiece));
exports.Knight = Knight;
